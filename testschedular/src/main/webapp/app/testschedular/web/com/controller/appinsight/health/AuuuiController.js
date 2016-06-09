Ext.define('Testschedular.testschedular.web.com.controller.appinsight.health.AuuuiController', {
     extend: 'Testschedular.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.AuuuiController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_15890'), this.view.down('#textfield_ext_15902'), this.view.down('#textfield_ext_15916')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.aDay = this.view.down('#textfield_ext_15890').getValue();
          jsonData.aMonth = this.view.down('#textfield_ext_15902').getValue();
          jsonData.aYear = this.view.down('#textfield_ext_15916').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/TestSchduleEsWS/proTestSchduleEs',
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
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    scope.sender.controller.responseHandler(responseText);
               }
          }, scope);
     }
});