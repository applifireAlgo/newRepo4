Ext.define('Testaone.testaone.web.com.controller.appinsight.health.SchUiController', {
     extend: 'Testaone.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.SchUiController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_13525'), this.view.down('#textfield_ext_13536'), this.view.down('#textfield_ext_13548')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.aday = this.view.down('#textfield_ext_13525').getValue();
          jsonData.aMonth = this.view.down('#textfield_ext_13536').getValue();
          jsonData.aYear = this.view.down('#textfield_ext_13548').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/EmpScDsWS/proEmpScDs',
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
                         Ext.Msg.alert('Server Response', 'Mail Sent Successfuly');
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