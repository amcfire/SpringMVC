package com.onlineShop.controller;

import com.onlineShop.dao.ProductDao;
import com.onlineShop.dao.impl.ProductDaoImpl;
import com.onlineShop.model.*;
import com.onlineShop.model.model_DTO.Product_Dao;
import com.onlineShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.*;


/*
 *  Created by Solomon 10/19/2018
 *  Online Shopping
 *
 *      Vendor Product Controller
 * */
@Controller
@SessionAttributes("currentuser")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.GET)
    public String vendorProfile(@PathVariable int vendorId, Model model,
                                HttpServletRequest request) {
        try {

            Vendor vendor = vendorService.findVendorById(vendorId);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            Address address = addressService.getAddressByUserId(vendorId);
//            vendor.setAddress(address);

            System.out.println(vendor.getFirstName() + "=============================================== -1 ");

            List<Product> productList = vendor.getProductList();
            System.out.println(vendor.getName() + "-------------------------------------------------------------------------- 0");
            model.addAttribute("vendor", vendor);
            model.addAttribute("category",categoryService.findAllCategories());
            model.addAttribute("product", productList);
        } catch (Exception e) {
            System.out.println(e.getCause() + "" + e.getMessage());
        }

        return "template/dashboard/vendorproduct";

    }

    @RequestMapping(value = "vendore/product/edit/{id}", method = RequestMethod.GET)
    public String editget(@PathVariable int id, Model  model){
        Product product = productService.getProductById(id);

            model.addAttribute("product",product);

        return"vendore/product/edit";
    }

    @RequestMapping(value = "vendore/product/edit",method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            model.addAttribute("product",product);
            return "vendore/product/edit";
        }
        productService.editProduct(product);
        return "redirect:/vendor/product/"+product.getProductId();
    }

    @RequestMapping(value = "vendor/product/{ProductId}", method = RequestMethod.GET)
    public String getProduct(@PathVariable long proid, Model model){
        Product product = productService.getProductById(proid);
        model.addAttribute("product",product);
        return "template/dashboard/viewproduct_solomon";
    }

    @RequestMapping(value = "vendor/product/delete/{id}", method = RequestMethod.POST)
    public String deleteProductById(@PathVariable long id){
        productService.deletProductById(id);
        int vendorId = productService.getProductById(id).getVendor_id().getVendorId();
        return "redirect:/vendor/"+vendorId;
    }

    @RequestMapping(value = "/vendor/product/view", method = RequestMethod.GET)
    public String viewProduct(@ModelAttribute("product") Product product, Model model) {
        return "template/shop/productview";
    }

    @RequestMapping(value = "/vendor/product/new", method = RequestMethod.GET)
    public String doAdd(Model model) {
        System.out.println("1111111111111111111111111111111111111111-----------------------1111111111111111111111111111111111");
        List<Category> categoryList = categoryService.findAllCategories();
        Product_Dao productDao= new Product_Dao();
        model.addAttribute("product", productDao);
        model.addAttribute("categories", categoryList);
        return "template/dashboard/vendorproductnew";
    }

    @RequestMapping(value = "/vendor/product/new", method = RequestMethod.POST)
    public String addproductbyVendor(@ModelAttribute("product") @Valid Product_Dao productToBeAdded,
                                     BindingResult result, RedirectAttributes redirectAttributes,
                                     Model model, String categoryId,
                                     HttpSession session) {
        /*
         *
         * vendorId_solo have to be changed after integration in to the sessionName
         * */
        //Integer vendorId_ = (Integer)session.getAttribute("currentVendor");
        //List<Category> categoryList = categoryService.findAllCategories();


        //model.addAttribute("categories", categoryList);
        //System.out.println("caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacaaaaaaaaaaaaaaaaaaaaaaaa   ---    ");

       session.setAttribute("currentuser", 1);
        if (result.hasErrors()) {
            System.out.println("0000000000000000000-------------------------------------000000000000000000000000000000000" + result.getFieldErrors());
            return "template/dashboard/vendorproductnew";
        }
        Integer vendorId = (Integer) session.getAttribute("currentuser");
        Vendor loginuser = new Vendor();
        if (vendorId != null) {

            System.out.println(vendorId+" -==-=-=-=-=-=-=-=-=-=");
            loginuser = vendorService.findVendorById(vendorId);
        }
        System.out.println(loginuser.getName() + " = 00000000000000000000000000000000000000000000000000000000000000000000000000");
        Product product = (Product) ProductFactory.getINSTANCE().createUserFromDto(productToBeAdded);
        product.setVendor_id(loginuser);
        //product.setCategory(category);
        List<ProductImage> productImages = new ArrayList<ProductImage>();
        List<MultipartFile> multipartFiles = productToBeAdded.getInputImages();
        String imagename = null;

        System.out.println("EMpty +++++++++++++++++" + "0000000000000000000000000000000000" + "------------------");

        if (multipartFiles != null) {
            for (MultipartFile malti : multipartFiles) {
                if (malti != null && !malti.isEmpty()) {
                    try {
                        manageDirectory("c:\\images");
                        imagename = new Date().getDate() + "" + malti.getOriginalFilename();
                        malti.transferTo(new File("c:\\images\\" + imagename));
                        productImages.add(new ProductImage(imagename));
                    } catch (Exception e) {
                        //     throw new FileNotFoundException("Unable to save image: " + malti.getOriginalFilename());
                        System.out.println("picture problem" + malti.getOriginalFilename() + "   ==============================00000000000000000000000000000--------------------------");
                    }
                }
            }

        }
        product.setProductImageList(productImages);
        if (productImages.size() > 0)
            product.setMainPicturePath(productImages.get(0).getUrl());
        System.out.println("-----------------------------------------------11111111111111111111111111111111111111111111111111111111111111111111111");
        try {
            productService.saveProduct(product);
        } catch (Exception s) {
            s.getCause();
        }

        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/vendor/"+vendorId;
    }


    private void manageDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    //By Krishna

//    @Autowired
//    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/myadmin/addVendor", method = RequestMethod.GET)
    public String registerVendor(Model model){
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/vendor-form";
    }

    @RequestMapping(value = "/myadmin/addVendor", method = RequestMethod.POST)
    public String saveVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "/template/shop/adminview/vendor-form";
        }
//
//        List<Vendor> vendorList = vendorService.getAllVendor();
//        for(int i = 0; i< vendorList.size(); i++){
//            if (vendor.getUser().getUserName().equals(vendorList.get(i).getUser().getUserName())){
//                model.addAttribute("emailMsg", "Email Already Exist");
//
//                return "/template/shop/adminview/vendor-form";
//            }
//        }

        vendorService.addVendor(vendor);

        String url = "/template/shop/adminview/vendor-payment";

//        return "/template/shop/adminview/vendor-registration-success";
        return url;
//
    }

    @RequestMapping(value = "/myadmin/getAllPendingVendors", method = RequestMethod.GET)
    public String getAllPendingVendors(Model model){

        List<Vendor> vendorList = vendorService.getAllPendingVendor();
        model.addAttribute("vendor", vendorList);
        return "/template/shop/adminview/new-vendor-list";
    }

    //Pulling pending vendor by Id to display in detail page

    @RequestMapping(value = "/myadmin/getPendingVendorById/{vendorId}", method = RequestMethod.GET)
    public String getPendingVendorById(@PathVariable int vendorId, Model model){
        Vendor vendor = vendorService.getPendingVendorById(vendorId);
        System.out.println(vendorId+"==================");
        System.out.println(vendor.getFirstName()+"==================");
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/new-vendor-detail";
    }

    @RequestMapping(value = "/myadmin/vendorApprove", method = RequestMethod.GET)
    public String vendorApprovGet(Model model){
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/new-vendor-detail";
    }


    @RequestMapping(value = "/myadmin/vendorApprove", method = RequestMethod.POST)
    public String vendorApprovePost(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, Model model){
        vendor.setStatus("approved");
        vendorService.updateVendorStatus(vendor);
        return "/template/shop/adminview/new-vendor-approval-success";
    }
/*
    @RequestMapping(value = "/vendorPayment", method = RequestMethod.GET)
    public String vendorPayment(Model model){

        subscriptionService.getSubscription().getAmount();

        return "/template/shop/adminview/vendor-registration-success";

    }*/

}
