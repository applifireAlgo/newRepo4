Ext.define('Testlic1.testlic1.web.com.controller.appinsight.health.TestuiController', {
     extend: 'Testlic1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.TestuiController',
     onAddClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#numberfield_ext_4447'), this.view.down('#numberfield_ext_4458')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.ano = this.view.down('#numberfield_ext_4447').getValue();
          jsonData.ano1 = this.view.down('#numberfield_ext_4458').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/TestDsWS/proTestDs',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
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