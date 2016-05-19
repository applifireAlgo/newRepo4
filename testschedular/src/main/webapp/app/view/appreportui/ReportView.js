Ext.define('Testschedular.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testschedular.view.appreportui.ReportViewController',
	            'Testschedular.view.appreportui.datagrid.DataGridPanel',
	            'Testschedular.view.appreportui.datagrid.DataGridView',
	            'Testschedular.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testschedular.view.appreportui.chart.ChartView',
	            'Testschedular.view.appreportui.datapoint.DataPointView',
	            'Testschedular.view.googlemaps.map.MapPanel',
	            'Testschedular.view.appreportui.chartpoint.ChartPointView'
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
