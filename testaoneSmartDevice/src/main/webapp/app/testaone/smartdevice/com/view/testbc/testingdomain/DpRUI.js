Ext.define('Testaone.testaone.smartdevice.com.view.testbc.testingdomain.DpRUI', {
     "xtype": "dpRUI",
     "items": [{
          "xtype": "reportView",
          "name": "dp",
          "title": "Dp Report",
          "isCustomReport": true,
          "reportWidgets": ["1", "2", "3"],
          "refId": "4FE5AE1D-8579-4BD0-A604-9E9C84A438A7",
          "margin": 5,
          "itemId": "reportView_ext_18011"
     }],
     "border": true,
     "autoScroll": false,
     "layout": "fit",
     "title": "Fit Layout",
     "margin": 5,
     "itemId": "panel_ext_18001",
     "dockedItems": [],
     "requires": ["Testaone.view.smartdevice.reportview.ReportMainView", "Testaone.testaone.smartdevice.com.controller.testbc.testingdomain.DpRUIController", "Testaone.testaone.shared.com.viewmodel.testbc.testingdomain.DpRUIViewModel", "Testaone.testaone.shared.com.model.testbc.testingdomain.DpRUIModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "DpRUIViewModel",
     "controller": "DpRUIController"
});