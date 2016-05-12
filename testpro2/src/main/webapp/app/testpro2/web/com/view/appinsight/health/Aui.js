Ext.define('Testpro2.testpro2.web.com.view.appinsight.health.Aui', {
     "xtype": "aui",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "Name",
          "margin": 5,
          "bindable": "tnm",
          "name": "tnm",
          "itemId": "textfield_ext_12535"
     }, {
          "xtype": "textfield",
          "fieldLabel": "No",
          "margin": 5,
          "bindable": "tno",
          "name": "tno",
          "itemId": "textfield_ext_12546"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_12769",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_12506",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testpro2.testpro2.web.com.controller.appinsight.health.AuiController", "Testpro2.testpro2.shared.com.viewmodel.appinsight.health.AuiViewModel", "Testpro2.testpro2.shared.com.model.appinsight.health.AuiModel"],
     "viewModel": "AuiViewModel",
     "controller": "AuiController"
});