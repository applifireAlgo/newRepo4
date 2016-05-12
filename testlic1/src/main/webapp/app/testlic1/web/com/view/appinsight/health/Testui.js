Ext.define('Testlic1.testlic1.web.com.view.appinsight.health.Testui', {
     "xtype": "testui",
     "items": [{
          "xtype": "numberfield",
          "fieldLabel": "Number1",
          "name": "ano",
          "margin": 5,
          "bindable": "ano",
          "itemId": "numberfield_ext_4447"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Number2",
          "name": "ano1",
          "margin": 5,
          "bindable": "ano1",
          "itemId": "numberfield_ext_4458"
     }, {
          "xtype": "button",
          "name": "Add",
          "text": "Add",
          "margin": 5,
          "itemId": "button_ext_4470",
          "listeners": {
               "click": "onAddClick"
          }
     }, {
          "xtype": "grids",
          "name": "Grid",
          "title": "Grid",
          "autoScroll": true,
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "aid",
               "hidden": true,
               "dataIndex": "aid",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "anm",
               "dataIndex": "anm",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "ano",
               "dataIndex": "ano",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "total",
               "dataIndex": "total",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "ano1",
               "dataIndex": "ano1",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "primaryDisplay",
               "hidden": true,
               "dataIndex": "primaryDisplay",
               "flex": 1
          }],
          "itemId": "gridpanel_ext_4484",
          "store": {
               "autoLoad": true,
               "autoSync": true,
               "model": "Testlic1.testlic1.shared.com.model.appinsight.health.TestAModel",
               "proxy": {
                    "type": "ajax",
                    "url": "secure/TestA/findAll",
                    "serviceId": "B6731134-8430-46E0-8E08-BF6C9364C661",
                    "serviceOperationId": "496B2E41-246B-4158-842B-1BCD6BE32DC7",
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
          "tools": [{
               "type": "refresh",
               "tooltip": "Refresh Grid Data",
               "handler": "onGridRefreshClick"
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_4436",
     "dockedItems": [],
     "requires": ["Testlic1.testlic1.shared.com.model.appinsight.health.TestAModel", "Testlic1.testlic1.web.com.controller.appinsight.health.TestuiController", "Testlic1.testlic1.shared.com.viewmodel.appinsight.health.TestuiViewModel", "Testlic1.testlic1.shared.com.model.appinsight.health.TestuiModel", "Testlic1.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "TestuiViewModel",
     "controller": "TestuiController"
});