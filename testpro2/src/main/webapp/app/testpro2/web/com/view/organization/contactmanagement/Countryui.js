Ext.define('Testpro2.testpro2.web.com.view.organization.contactmanagement.Countryui', {
     "xtype": "countryui",
     "items": [{
          "xtype": "combo",
          "name": "CountryId",
          "margin": 5,
          "bindable": "CountryId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "CountryId",
          "displayField": "countryName",
          "valueField": "countryId",
          "itemId": "combo_ext_4420",
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
          },
          "listeners": {
               "change": "onCountryIdChange"
          }
     }, {
          "xtype": "combo",
          "name": "stateId",
          "margin": 5,
          "bindable": "stateId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "State",
          "displayField": "stateName",
          "valueField": "stateId",
          "itemId": "combo_ext_4576",
          "isRelatedWith": "hniickpgi",
          "store": {
               "model": "Testpro2.testpro2.shared.com.model.organization.locationmanagement.StateModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "stateName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/State/findAll",
                    "serviceId": "E7AE7ED4-E91B-4B1B-9CBB-BCBFA83EEA84",
                    "serviceOperationId": "C9E1F58A-B918-4C62-BBF9-04AD63A15FEB",
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
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_4411",
     "dockedItems": [],
     "requires": ["Testpro2.testpro2.shared.com.model.organization.locationmanagement.CountryModel", "Testpro2.testpro2.shared.com.model.organization.locationmanagement.StateModel", "Testpro2.testpro2.web.com.controller.organization.contactmanagement.CountryuiController", "Testpro2.testpro2.shared.com.viewmodel.organization.contactmanagement.CountryuiViewModel", "Testpro2.testpro2.shared.com.model.organization.contactmanagement.CountryuiModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "CountryuiViewModel",
     "controller": "CountryuiController"
});