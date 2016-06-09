Ext.define('Testpro2.testpro2.web.com.controller.appinsight.health.AuiController', {
     extend: 'Testpro2.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.AuiController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_12546')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.tno = this.view.down('#textfield_ext_12546').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/TestCDsssWS/proTestCDsss',
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
                         var responseData = responseText.response.data;
                         scope.sender.down('#textfield_ext_12535').setValue(responseData.tnm);
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