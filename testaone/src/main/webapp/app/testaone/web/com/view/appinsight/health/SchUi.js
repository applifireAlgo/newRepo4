Ext.define('Testaone.testaone.web.com.view.appinsight.health.SchUi', {
     "xtype": "schUi",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "Day",
          "margin": 5,
          "bindable": "Day",
          "name": "Day",
          "itemId": "textfield_ext_13525"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Month",
          "margin": 5,
          "bindable": "Month",
          "name": "Month",
          "itemId": "textfield_ext_13536"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Year",
          "margin": 5,
          "bindable": "Year",
          "name": "Year",
          "itemId": "textfield_ext_13548"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_13563",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_13515",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testaone.testaone.web.com.controller.appinsight.health.SchUiController", "Testaone.testaone.shared.com.viewmodel.appinsight.health.SchUiViewModel", "Testaone.testaone.shared.com.model.appinsight.health.SchUiModel"],
     "viewModel": "SchUiViewModel",
     "controller": "SchUiController"
});