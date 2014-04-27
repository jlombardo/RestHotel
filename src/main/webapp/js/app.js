/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// The root URL for the RESTful services
var rootURL = "http://localhost:8080/hotels";
var currentHotel;

// Retrieve hotel list when application starts
findAll();

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
    search($('#searchKey').val());
    return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e) {
    if (e.which == 13) {
        search($('#searchKey').val());
        e.preventDefault();
        return false;
    }
});

$('#btnAdd').click(function() {
    newHotel();
    return false;
});

$('#btnSave').click(function() {
    if ($('#hotelId').val() == '')
        addHotel();
    else
        updateHotel();
    return false;
});

$('#btnDelete').click(function() {
    deleteHotel();
    return false;
});

$('#hotelList').on('click', "a", function() {
    findById($(this).data('identity'));
});

function search(searchKey) {
    if (searchKey == '')
        findAll();
    else
        findByName(searchKey);
}

function newHotel() {
    $('#btnDelete').hide();
    currentHotel = {};
    renderDetails(currentHotel); // Display empty form
}

function findAll() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL,
        dataType: "json", // data type of response
        success: renderList
    });
}

function renderList(data) {
    // JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
    var list = data == null ? [] : (data instanceof Array ? data : [data]);

    $('#hotelList li').remove();
    $.each(data._embedded.hotels, function(index, obj) {
        $('#hotelList').append('<li><a href="#" data-identity="' + obj._links.self.href +'">' + obj.name + '</a></li>');
    });
}

function findByName(searchKey) {
    console.log('findByName: ' + searchKey);
    $.ajax({
        type: 'GET',
        url: rootURL + '/search/' + searchKey,
        dataType: "json",
        success: renderList
    });
}

function findById(self) {
    console.log(self);
    $.ajax({
        type: 'GET',
        url: self,
        dataType: "json",
        success: function(data, textstatus) {
            $('#btnDelete').show();
            console.log('findById success: ' + data.name);
            currentHotel = data;
            renderDetails(currentHotel);
        }
    });
}

function addHotel() {
    console.log('addHotel');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL,
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR) {
            alert('Hotel created successfully');
            $('#btnDelete').show();
            $('#hotelId').val(data.id);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('addHotel error: ' + textStatus);
        }
    });
}

function updateHotel() {
    console.log('updateHotel');
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/' + $('#hotelId').val(),
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR) {
            alert('Hotel updated successfully');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('updateHotel error: ' + textStatus);
        }
    });
}

function deleteHotel() {
    console.log('deleteHotel');
    $.ajax({
        type: 'DELETE',
        url: rootURL + '/' + $('#hotelId').val(),
        success: function(data, textStatus, jqXHR) {
            alert('Hotel deleted successfully');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('deleteHotel error');
        }
    });
}

function renderDetails(hotel) {
	var id = hotel._links.self.href;
        var idx = id.lastIndexOf("/");
        id = id.substring(idx+1);
        $('#hotelId').val(id);
	$('#name').val(hotel.name);
	$('#address').val(hotel.address);
	$('#city').val(hotel.city);
	$('#zip').val(hotel.zip);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var hotelId = $('#hotelId').val();
	return JSON.stringify({
		"id": hotelId == "" ? null : hotelId, 
		"name": $('#name').val(), 
		"address": $('#address').val(),
		"city": $('#city').val(),
		"zip": $('#zip').val(),
		});
}
