'use strict';

describe('Controller: UploadCtrl', function () {

  // load the controller's module
  beforeEach(module('myAppYoApp'));

  var UploadCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UploadCtrl = $controller('UploadCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UploadCtrl.awesomeThings.length).toBe(3);
  });
});
