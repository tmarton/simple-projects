'use strict';

var path = require('path');
var gulp = require('gulp');
var conf = require('./conf');
var inject = require('gulp-inject');

var $ = require('gulp-load-plugins')();
var _ = require('lodash');

var wiredep = require('wiredep').stream;

gulp.task('inject', function () {
  var injectStyles = gulp.src([
    path.join(conf.paths.src, '/css/**/*.css')
  ], { read: false });


  var injectScripts = gulp.src([
    path.join(conf.paths.src, '/script/**/*.js')
  ]);

  var injectOptions = {
    ignorePath: [conf.paths.src, path.join(conf.paths.tmp, '/serve')],
    addRootSlash: false
  };

  return gulp.src(path.join(conf.paths.src, '/index.html'))
    .pipe(inject(injectStyles, injectOptions))
    .pipe(inject(injectScripts, injectOptions))
    .pipe(wiredep(_.extend({}, conf.wiredep)))
    .pipe(gulp.dest(path.join(conf.paths.src, conf.paths.tmp)));
});

gulp.task('copy', function() {
  gulp.src(path.join(conf.paths.src, conf.paths.tmp, 'index.html'))
      .pipe(gulp.dest(conf.paths.src));
});