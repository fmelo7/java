'use strict';

describe('Filter: extensionsplit', function () {

  // load the filter's module
  beforeEach(module('myAppYoApp'));

  // initialize a new instance of the filter before each test
  var extensionsplit;
  beforeEach(inject(function ($filter) {
    extensionsplit = $filter('extensionsplit');
  }));

  it('should return the input prefixed with "extensionsplit filter:"', function () {
    var text = 'angularjs';
    expect(extensionsplit(text)).toBe('extensionsplit filter: ' + text);
  });

});
