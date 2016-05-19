Ext.define('Testschedular.testschedular.web.com.view.appinsight.health.Auuui', {
     "xtype": "auuui",
     "items": [{
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_15866",
          "listeners": {
               "click": "onButtonClick"
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "TextField",
          "margin": 5,
          "bindable": "a",
          "name": "a",
          "itemId": "textfield_ext_15890"
     }, {
          "xtype": "textfield",
          "fieldLabel": "TextField",
          "margin": 5,
          "bindable": "b",
          "name": "b",
          "itemId": "textfield_ext_15902"
     }, {
          "xtype": "textfield",
          "fieldLabel": "TextField",
          "margin": 5,
          "bindable": "c",
          "name": "c",
          "itemId": "textfield_ext_15916"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_15856",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testschedular.testschedular.web.com.controller.appinsight.health.AuuuiController", "Testschedular.testschedular.shared.com.viewmodel.appinsight.health.AuuuiViewModel", "Testschedular.testschedular.shared.com.model.appinsight.health.AuuuiModel"],
     "viewModel": "AuuuiViewModel",
     "controller": "AuuuiController"
});