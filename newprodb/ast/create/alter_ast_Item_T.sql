

ALTER TABLE ast_Item_T ADD CONSTRAINT fk_c7d907a63 FOREIGN KEY (categorynm) REFERENCES ast_Category_M(cid);



ALTER TABLE ast_Item_T ADD CONSTRAINT fk_e2e70a17c FOREIGN KEY (brandnm) REFERENCES ast_Brands_M(bid);



exit;