Ext.define('Testpro2.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testpro2.view.appreportui.ReportViewController',
	            'Testpro2.view.appreportui.datagrid.DataGridPanel',
	            'Testpro2.view.appreportui.datagrid.DataGridView',
	            'Testpro2.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testpro2.view.appreportui.chart.ChartView',
	            'Testpro2.view.appreportui.datapoint.DataPointView',
	            'Testpro2.view.googlemaps.map.MapPanel',
	            'Testpro2.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
