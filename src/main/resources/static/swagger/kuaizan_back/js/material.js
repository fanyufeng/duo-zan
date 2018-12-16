(function($) {
  'use strict';
  $(function() {

    $('[data-toggle="expansionPanel"]').on('click', function() {
      $('#' + $(this).attr("target-panel")).toggleClass('expanded');
    });

    /* Dropdown */
    $('[data-toggle="dropdown"]').on('click', function() {
      var menuEl = document.querySelector('#' + $(this).attr("toggle-dropdown"));
      var menu = new mdc.menu.MDCSimpleMenu(menuEl);
      menu.open = !menu.open;
    });

    mdc.autoInit();

    /* Select menu */
    var MDCSelect = mdc.select.MDCSelect;
    if ($('#hero-js-select').length) {
      var heroSelect = document.getElementById('hero-js-select');
      var heroSelectComponent = new mdc.select.MDCSelect(heroSelect);
    }
      if ($('#adProject-js-select').length) {
          var heroSelect = document.getElementById('adProject-js-select');
          var heroSelectComponent = new mdc.select.MDCSelect(heroSelect);
      }

    /* text field */
    if ($('#tf-box-example').length) {
      var tfEl = document.getElementById('tf-box-example');
      var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper').length) {
      var wrapper = document.getElementById('demo-tf-box-wrapper');
    }
    if ($('#tf-box-address-example').length) {
      var tfBoxLeadingEl = document.getElementById('tf-box-address-example');
      var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-address-wrapper').length) {
      var wrapperBoxLeading = document.getElementById('demo-tf-box-address-wrapper');
    }
    if ($('#tf-box-name-example').length) {
      var tfBoxLeadingEl = document.getElementById('tf-box-name-example');
      var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-name-wrapper').length) {
      var wrapperBoxLeading = document.getElementById('demo-tf-box-name-wrapper');
    }
    if ($('#tf-box-poc-example').length) {
      var tfBoxLeadingEl = document.getElementById('tf-box-poc-example');
      var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-poc-wrapper').length) {
      var wrapperBoxLeading = document.getElementById('demo-tf-box-poc-wrapper');
    }
    if ($('#tf-box-contact-example').length) {
      var tfBoxLeadingEl = document.getElementById('tf-box-contact-example');
      var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-contact-wrapper').length) {
      var wrapperBoxLeading = document.getElementById('demo-tf-box-contact-wrapper');
    }
      if ($('#tf-box-qr-example').length) {
          var tfBoxLeadingEl = document.getElementById('tf-box-qr-example');
          var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
      }
      if ($('#demo-tf-box-qr-wrapper').length) {
          var wrapperBoxLeading = document.getElementById('demo-tf-box-qr-wrapper');
      }
      if ($('#tf-box-price-example').length) {
          var tfBoxLeadingEl = document.getElementById('tf-box-price-example');
          var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
      }
      if ($('#demo-tf-box-price-wrapper').length) {
          var wrapperBoxLeading = document.getElementById('demo-tf-box-price-wrapper');
      }
      if ($('#tf-box-upload-example').length) {
          var tfBoxLeadingEl = document.getElementById('tf-box-upload-example');
          var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
      }
      if ($('#demo-tf-box-upload-wrapper').length) {
          var wrapperBoxLeading = document.getElementById('demo-tf-box-upload-wrapper');
      }
      if ($('#tf-outlined-example').length) {
      var tfEl = document.getElementById('tf-outlined-example');
      var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper').length) {
      var wrapper = document.getElementById('demo-tf-outlined-wrapper');
    }
  });
})(jQuery);