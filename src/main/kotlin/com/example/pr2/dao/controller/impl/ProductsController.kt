package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.ProductDao
import com.example.pr2.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/products")
@Controller
class ProductsController(
    @Autowired productDao: ProductDao
) : BaseController<Product>(
    dao = productDao,
    path = "products",
    views = BaseViews(
        editView = "edit_product"
    ),
    search = { productDao.findAllByNameContainsIgnoreCase(it) }

)