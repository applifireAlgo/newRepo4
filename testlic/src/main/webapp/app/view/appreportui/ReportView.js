Ext.define('Testlic.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testlic.view.appreportui.ReportViewController',
	            'Testlic.view.appreportui.datagrid.DataGridPanel',
	            'Testlic.view.appreportui.datagrid.DataGridView',
	            'Testlic.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testlic.view.appreportui.chart.ChartView',
	            'Testlic.view.appreportui.datapoint.DataPointView',
	            'Testlic.view.googlemaps.map.MapPanel',
	            'Testlic.view.appreportui.chartpoint.ChartPointView'
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
		boxready : 'fetchReportData',
		added:'onReportAdded'
	}
});
