Ext.define('Testlic.testlic.web.com.controller.testbc.testing.AuiController', {
     extend: 'Testlic.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.AuiController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_10352'), this.view.down('#textfield_ext_10362')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.aName = this.view.down('#textfield_ext_10352').getValue();
          jsonData.aNo = this.view.down('#textfield_ext_10362').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/NameDsWS/proNameDs',
               async: false,
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
                    } else if (!sessionTimeOutFlag) {
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         scope.sender.controller.responseHandler(responseText);
                    }
               }
          }, scope);
     }
});