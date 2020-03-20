'use strict';

const core = require('./node_modules/vsc-leetcode-cli/lib/core.js');
const Plugin = require('./node_modules/vsc-leetcode-cli/lib/plugin');
var chalk = require('./node_modules/vsc-leetcode-cli/lib/chalk');
var config = require('./node_modules/vsc-leetcode-cli/lib/config');
var h = require('./node_modules/vsc-leetcode-cli/lib/helper');
var file = require('./node_modules/vsc-leetcode-cli/lib/file');
var icon = require('./node_modules/vsc-leetcode-cli/lib/icon');
var log = require('./node_modules/vsc-leetcode-cli/lib/log');
var fs = require('fs');
var TurndownService = require('turndown');
var tdService = new TurndownService();

function initPlugins(cb) {
    if (Plugin.init()) {
        Plugin.save();
        return cb();
    } else {
        Plugin.installMissings(function (e) {
            if (e) return cb(e);
            Plugin.init();
            return cb();
        });
    }
}
function initColor() {
    chalk.enabled = config.color.enable && chalk.enabled;
    chalk.init();
    chalk.setTheme(config.color.theme);
}

function initIcon() {
    icon.init();
    icon.setTheme(config.icon.theme);
}

function initLogLevel() {
    log.init();

    let level = 'INFO';
    if (process.argv.indexOf('-v') >= 0) level = 'DEBUG';
    if (process.argv.indexOf('-vv') >= 0) level = 'TRACE';

    // print HTTP details in TRACE
    if (level === 'TRACE') {
        const request = require('request');
        request.debug = true;

        console.error = _.wrap(console.error, function (func) {
            let args = Array.from(arguments);
            args.shift();

            // FIXME: hack HTTP request log, hope no one else use it...
            if (args.length > 0 && args[0].indexOf('REQUEST ') === 0) {
                args = args.map((x) => h.printSafeHTTP(x));
                log.trace.apply(log, args);
            } else {
                log.info.apply(log, args);
            }
        });
    }

    log.setLevel(level);
}

function initDir() {
    file.init();
    file.mkdir(file.homeDir())
}

config.init();
initColor();
initIcon();
initLogLevel();
initDir()

initPlugins(function(err) {
    if (err) 
        console.error(err);

    core.filterProblems({query: 'd'}, function(err, ps){
        if (err) log.fail(err);
        for (const _p of ps) {
            core.getProblem(_p, function(err, p) {
                if (err) log.fail(err);
                // log.inspect(p);
                let md = tdService.turndown(p.desc);
                md += ' \n' + '[' + p.link + ']' + '\n';
                // log.inspect(p);
                const fileName = '../problems/' + p.fid + '.' + p.name + '.md';
                fs.writeFile(fileName, md, function(err) {
                    if (err) log.fail(err);
                    log.info(fileName);
                });
            })
        }
    })

    // core.getProblem('1', function(err, p) {
    //     if(err) console.log(err);
        // const md = tdService.turndown(p.desc);
        // log.inspect(p);
        // const fileName = p.fid + '.' + p.name + '.md';
        // fs.writeFile(fileName, md, function(err) {
        //     if (err) log.fail(err);
        // })
    // });
});

