/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
module.exports = {
    get: function (url) {
        return browser.get(url);
    },
    getAndWaitForWholeApp: function (url) {
        return this.get(url).then(function () {
            return browser.waitForWholeAppToBeReady();
        });
    },
    getAndWaitForLogin: function (url) {
        return this.get(url).then(
            function () {
                this.clearCookies().then(
                    function () {
                        this.waitForLoginModal();
                    }.bind(this)
                );
            }.bind(this)
        );
    },
    waitForLoginModal: function () {
        return browser
            .waitUntil(
                protractor.ExpectedConditions.elementToBeClickable(
                    element(by.css('input[id^="username_"]'))
                ),
                'Timed out waiting for username input'
            )
            .then(function () {
                return browser.waitForAngular();
            });
    },
    setWaitForPresence: function (implicitWait) {
        browser.driver.manage().timeouts().implicitlyWait(implicitWait);
    },

    dumpAllLogsToConsole: function () {
        if (global.waitForSprintDemoLogTime === null || global.waitForSprintDemoLogTime <= 0) {
            return;
        }
        // List logs
        var logType = 'browser'; // browser
        browser.driver
            .manage()
            .logs()
            .getAvailableLogTypes()
            .then(function (logTypes) {
                if (logTypes.indexOf(logType) <= -1) {
                    return;
                }

                dumpAllLogsToConsoleSub();
            });
    },
    clearCookies: function () {
        return browser.waitUntil(function () {
            return browser.driver
                .manage()
                .deleteAllCookies()
                .then(
                    function () {
                        return true;
                    },
                    function (err) {
                        throw err;
                    }
                );
        }, 'Timed out waiting for cookies to clear');
    }
};

function dumpAllLogsToConsoleSub() {
    browser.driver
        .manage()
        .logs()
        .get(logType)
        .then(function (logsEntries) {
            logsEntries.forEach((logEntry) => {
                if (hasLogLevel(logEntry.level.name, global.sprintDemoLogLevels)) {
                    waitForSprintDemo(global.waitForSprintDemoLogTime);
                    try {
                        var msg = JSON.parse(logEntry.message);
                        console.log(msg.message.text);
                    } catch (err) {
                        if (global.sprintDemoShowLogParsingErrors) {
                            console.log('Error parsing log:  ' + logEntry.message);
                        }
                    }
                }
            });
        });
}
