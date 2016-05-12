

ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_567712320 FOREIGN KEY (reatilercode) REFERENCES ast_Retailer_M(retailercode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_54356a044 FOREIGN KEY (materialcode) REFERENCES ast_Material_M(materialcode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_14dff6714 FOREIGN KEY (category) REFERENCES ast_Category_M(categoryId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_622dc2bb1 FOREIGN KEY (channelId) REFERENCES ast_Channel_M(channelId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_6d3fd342f FOREIGN KEY (brandcode) REFERENCES ast_Brand_M(brandcode);



exit;