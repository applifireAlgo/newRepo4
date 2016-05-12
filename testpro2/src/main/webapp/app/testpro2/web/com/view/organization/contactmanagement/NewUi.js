Ext.define('Testpro2.testpro2.web.com.view.organization.contactmanagement.NewUi', {
     "xtype": "newUi",
     "items": [{
          "xtype": "panel",
          "items": [{
               "xtype": "textfield",
               "fieldLabel": "TextField",
               "margin": 5,
               "bindable": "t1",
               "name": "t1",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "textfield_ext_5297"
          }, {
               "xtype": "textfield",
               "fieldLabel": "TextField",
               "margin": 5,
               "bindable": "t2",
               "name": "t2",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "textfield_ext_5313"
          }, {
               "xtype": "textfield",
               "fieldLabel": "TextField",
               "margin": 5,
               "bindable": "t3",
               "name": "t3",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "textfield_ext_5331"
          }, {
               "xtype": "textfield",
               "fieldLabel": "TextField",
               "margin": 5,
               "bindable": "t4",
               "name": "t4",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "textfield_ext_5352"
          }, {
               "xtype": "combo",
               "name": "c1",
               "margin": 5,
               "bindable": "c1",
               "typeAhead": true,
               "queryMode": "local",
               "minChars": 1,
               "fieldLabel": "ComboBox",
               "displayField": "countryName",
               "valueField": "countryId",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "combo_ext_5374",
               "store": {
                    "model": "Testpro2.testpro2.shared.com.model.organization.locationmanagement.CountryModel",
                    "autoLoad": true,
                    "autoSync": true,
                    "sorters": [{
                         "property": "countryName",
                         "direction": "ASC"
                    }],
                    "proxy": {
                         "type": "ajax",
                         "url": "secure/Country/findAll",
                         "serviceId": "BE2ED03E-C2BC-40D4-8B1C-F5352C979830",
                         "serviceOperationId": "E8036863-2C28-46A9-A7D8-32F2C33F81AD",
                         "serviceType": 1,
                         "actionMethods": {
                              "read": "GET"
                         },
                         "headers": {
                              "Content-Type": "application/json"
                         },
                         "extraParams": {},
                         "reader": {
                              "type": "json",
                              "rootProperty": "response.data"
                         }
                    }
               }
          }],
          "layout": {
               "type": "table",
               "columns": 3,
               "tableAttrs": {
                    "style": {
                         "width": "100%"
                    }
               }
          },
          "title": "Table Layout",
          "border": true,
          "margin": 5,
          "itemId": "panel_ext_5282",
          "dockedItems": []
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_5272",
     "dockedItems": [],
     "requires": ["Testpro2.testpro2.shared.com.model.organization.locationmanagement.CountryModel", "Testpro2.testpro2.web.com.controller.organization.contactmanagement.NewUiController", "Testpro2.testpro2.shared.com.viewmodel.organization.contactmanagement.NewUiViewModel", "Testpro2.testpro2.shared.com.model.organization.contactmanagement.NewUiModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "NewUiViewModel",
     "controller": "NewUiController"
});