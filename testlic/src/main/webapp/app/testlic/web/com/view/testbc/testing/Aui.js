Ext.define('Testlic.testlic.web.com.view.testbc.testing.Aui', {
     "xtype": "auiView",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "Name",
          "margin": 5,
          "bindable": "aName",
          "name": "aName",
          "itemId": "textfield_ext_10352"
     }, {
          "xtype": "textfield",
          "fieldLabel": "No",
          "margin": 5,
          "bindable": "aNo",
          "name": "aNo",
          "itemId": "textfield_ext_10362"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_10374",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_10344",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testlic.testlic.web.com.controller.testbc.testing.AuiController", "Testlic.testlic.shared.com.viewmodel.testbc.testing.AuiViewModel", "Testlic.testlic.shared.com.model.testbc.testing.AuiModel"],
     "viewModel": "AuiViewModel",
     "controller": "AuiController"
});