package com.ecommerce;

import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.CategoryService;
import com.ecommerce.Services.ProductService;

import java.math.BigDecimal;

public class DBPopulator {


    public static void populateDB(){
        Category category1 = CategoryService.getCategoryById(1).get();
        Category category2 = CategoryService.getCategoryById(2).get();
        Product product1 = new Product();
        product1.setProductName("Esprit Ruffle Shirt");
        product1.setProductPrice(new BigDecimal(49.99));
        product1.setProductDescription("Esprit Ruffle shirt with long sleeves");
        product1.setCategory(category2);
        product1.setStockQuantity(10);
        product1.addProductImage("https://i.ibb.co/Vvn4CPG/product01-img1.jpg");
        product1.addProductImage("https://i.ibb.co/Fgt1smN/product01-img2.jpg");
        product1.addProductImage("https://i.ibb.co/N7KLBMt/product01-img3.jpg");



        ProductService.createProduct(product1);


        Product product2 = new Product();
        product2.setProductName("CROPPED BUTTONED JACKET");
        product2.setProductPrice(new BigDecimal(59.99));
        product2.setProductDescription("Cropped mock turtleneck jacket with long sleeves and buttoned cuffs with openings. Patch pockets on the front. Matching lining.");
        product2.setCategory(category2);
        product2.setStockQuantity(15);
        product2.addProductImage("https://i.postimg.cc/L6vQts3x/product02-img1.jpg");
        product2.addProductImage("https://i.postimg.cc/Z5R7Vhf4/product02-img2.jpg");
        product2.addProductImage("https://i.postimg.cc/52RPrkGv/product02-img3.jpg");


        ProductService.createProduct(product2);

        Product product3 = new Product();
        product3.setProductName("CROPPED JACKET WITH FLAPS");
        product3.setProductPrice(new BigDecimal(150.00));
        product3.setProductDescription("Blazer featuring a round neck and long sleeves. Front flap details. Fastens at the front with raised golden buttons.");
        product3.setCategory(category2);
        product3.setStockQuantity(20);
        product3.addProductImage("https://i.postimg.cc/cCdyJbdC/product03-img1.jpg");
        product3.addProductImage("https://i.postimg.cc/brLXS9vT/product03-img2.jpg");
        product3.addProductImage("https://i.postimg.cc/0221RFtH/product03-img3.jpg");
        ProductService.createProduct(product3);

        Product product4 = new Product();
        product4.setProductName("FLOWING RUFFLED BLOUSE");
        product4.setProductPrice(new BigDecimal(150.00));
        product4.setProductDescription("Round neck blouse made of 100% spun viscose. Long sleeves with cuffs. Ruffled detail in matching fabric. Buttoned front.");
        product4.setCategory(category2);
        product4.setStockQuantity(20);
        product4.addProductImage("https://i.postimg.cc/3wS6CxjX/product04-img1.jpg");
        product4.addProductImage("https://i.postimg.cc/NFTzc83D/product04-img2.jpg");
        product4.addProductImage("https://i.postimg.cc/fW0FmZVd/product04-img3.jpg");
        ProductService.createProduct(product4);


        Product product5 = new Product();
        product5.setProductName("ROMANTIC BLOUSE WITH LACE TRIM");
        product5.setProductPrice(new BigDecimal(200.00));
        product5.setProductDescription("Round neck blouse made of 100% spun viscose. Long sleeves with cuffs. Ruffled detail in matching fabric. Buttoned front.");
        product5.setCategory(category2);
        product5.setStockQuantity(14);
        product5.addProductImage("https://i.postimg.cc/rwpNGCfH/product05-img1.jpg");
        product5.addProductImage("https://i.postimg.cc/Dwm14fZk/product05-img2.jpg");
        product5.addProductImage("https://i.postimg.cc/YSWg8XYd/product05-img3.jpg");
        ProductService.createProduct(product5);


        Product product6 = new Product();
        product6.setProductName("SOFT SHIRT WITH POCKET");
        product6.setProductPrice(new BigDecimal(250.00));
        product6.setProductDescription("Relaxed-fit collared shirt made of fabric with a velvety finish. Long sleeves with buttoned cuffs. Front patch pocket. Side vents at the hem. Button-up front.");
        product6.setCategory(category1);
        product6.setStockQuantity(10);
        product6.addProductImage("https://i.postimg.cc/WbyhKG2C/product06-img1.jpg");
        product6.addProductImage("https://i.postimg.cc/y6QdgmSx/product06-img2.jpg");
        product6.addProductImage("https://i.postimg.cc/x1HT4BpN/product06-img3.jpg");
        ProductService.createProduct(product6);

        Product product7 = new Product();
        product7.setProductName("EXTRA HEAVY WEIGHT T-SHIRT");
        product7.setProductPrice(new BigDecimal(16.00));
        product7.setProductDescription("T-shirt made of 100% cotton fabric. Round neck and short sleeves.");
        product7.setCategory(category1);
        product7.setStockQuantity(10);
        product7.addProductImage("https://i.postimg.cc/521NDnhP/product07-img1.jpg");
        product7.addProductImage("https://i.postimg.cc/pdLVLyXz/product07-img2.jpg");
        product7.addProductImage("https://i.postimg.cc/3RyK26Gw/4000.jpg");
        ProductService.createProduct(product7);


        Product product8 = new Product();
        product8.setProductName("COMPACT SWEATSHIRT");
        product8.setProductPrice(new BigDecimal(25.00));
        product8.setProductDescription("Loose-fitting sweatshirt with a wide ribbed neck and short sleeves.");
        product8.setCategory(category1);
        product8.setStockQuantity(10);
        product8.addProductImage("https://i.postimg.cc/3xbV2wFg/product08-img1.jpg");
        product8.addProductImage("https://i.postimg.cc/jSCkqbYC/product08-img2.jpg");
        product8.addProductImage("https://i.postimg.cc/JzgYG2Rx/product08-img3.jpg");
        ProductService.createProduct(product8);

        Product product9 = new Product();
        product9.setProductName("TEXTURED T-SHIRT");
        product9.setProductPrice(new BigDecimal(100.00));
        product9.setProductDescription("Round neck T-shirt featuring long sleeves with ribbed cuffs.");
        product9.setCategory(category1);
        product9.setStockQuantity(10);
        product9.addProductImage("https://i.postimg.cc/MpjbrK80/product09-img1.jpg");
        product9.addProductImage("https://i.postimg.cc/26CQ6QLT/product09-img2.jpg");
        product9.addProductImage("https://i.postimg.cc/Gt2vPbQy/product09-img3.jpg");
        ProductService.createProduct(product9);

        Product product10 = new Product();
        product10.setProductName("BOXY FIT JACKET");
        product10.setProductPrice(new BigDecimal(4000.00));
        product10.setProductDescription("Boxy-fit jacket with a lapel collar and long sleeves. Front welt pockets and a chest pocket. Front button fastening.");
        product10.setCategory(category1);
        product10.setStockQuantity(10);
        product10.addProductImage("https://i.postimg.cc/mrLk18Vc/product10-img1.jpg");
        product10.addProductImage("https://i.postimg.cc/SxpGX25X/product10-img2.jpg");
        product10.addProductImage("https://i.postimg.cc/mrLNjxTB/product10-img3.jpg");
        ProductService.createProduct(product10);
    }

}
