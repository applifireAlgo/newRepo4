Ext.define('Testpro2.testpro2.web.com.controller.organization.contactmanagement.CountryuiController', {
     extend: 'Testpro2.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.CountryuiController',
     onCountryIdChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_4420').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/State/findByCountryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_4576 = scope.sender.down('#combo_ext_4576');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_4576, 'stateName', 'stateId');
                    } else {
                         scope.sender.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    scope.sender.responseHandler(responseText);
               }
          }, scope);
     }
});