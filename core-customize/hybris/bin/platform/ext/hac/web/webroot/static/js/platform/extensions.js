$(document).ready(function() {
	$('#extensions').dataTable({
		"bStateSave" : true,
		"iDisplayLength" : 50,
		"aaSorting" : [ [ 0, "asc" ] ],
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 2, 3 ] } ],
		"aLengthMenu" : [[10,25,50,100,-1], [10,25,50,100,'all']]
	});

	$("body").on('click', '.extensionName',function() {
		var extName = $(this).attr('data-extensionname');
		var url = $('#extensions').attr('data-dependencyurl');

		$.ajax({
			url : url,
			type : 'GET',
			data : 'extension=' + extName,
			headers : {
				'Accept' : 'application/json'
			},
			success : function(data) {
				var extList =$("<ul/>");
				for (pos in data.dependencies) {
                    if (data.dependencies.hasOwnProperty(pos)) {
                        extList.append($('<li/>').text(data.dependencies[pos]));
                    }
				}
				if (data.dependencies <= 3) {
					$('#dependenciesDialog').dialog('option', 'title', 'Extension ' + extName + ' has no dependency');
					$('#dependenciesDialog').dialog('option', 'height', 30);

				} else {
					$('#dependenciesDialog').dialog('option', 'height', 140);
					$('#dependenciesDialog').dialog('option', 'title', 'Extension ' + extName + ' depends on:');
				}

                $('#dependenciesDialog').html("");
				$('#dependenciesDialog').append(extList);
				$('#dependenciesDialog').dialog({'modal': true});
				$('#dependenciesDialog').dialog('open');
				return false;
			},
			error : hac.global.err
	    });
	});

	$(function() {
		$( "#dependenciesDialog" ).dialog({
			height: 140,
			autoOpen: false
		});
	});
});
