Ext.define('Testschedular.testschedular.web.com.view.appinsight.health.NewUi', {
     "xtype": "newUi",
     "items": [{
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_15350",
          "listeners": {
               "click": "onButtonClick"
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "Day",
          "margin": 5,
          "bindable": "Day",
          "name": "Day",
          "itemId": "textfield_ext_15493"
     }, {
          "xtype": "textfield",
          "fieldLabel": "month",
          "margin": 5,
          "bindable": "month",
          "name": "month",
          "itemId": "textfield_ext_15505"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Year",
          "margin": 5,
          "bindable": "Year",
          "name": "Year",
          "itemId": "textfield_ext_15519"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_15342",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testschedular.testschedular.web.com.controller.appinsight.health.NewUiController", "Testschedular.testschedular.shared.com.viewmodel.appinsight.health.NewUiViewModel", "Testschedular.testschedular.shared.com.model.appinsight.health.NewUiModel"],
     "viewModel": "NewUiViewModel",
     "controller": "NewUiController"
});