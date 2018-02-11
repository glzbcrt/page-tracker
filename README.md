# Page Tracker &middot; [![Page Tracker license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/glzbcrt/page-tracker/blob/master/LICENSE) [![Build Status](https://travis-ci.org/glzbcrt/page-tracker.svg?branch=master)](https://travis-ci.org/glzbcrt/page-tracker)

Page Tracker is a sample web application I developed as part for a job interview.
It is a small application who tracks the pages where the user navigates and present this information in a feed.

## Quickstart

You can download a release from the GitHub release page.
Once you have downloaded the JAR file just run it like this:

java -jar page-tracker.jar

then go to your browser and acess http://localhost:8080.

Every page contains a small JavaScript snippet which trackes any hit the page gets.
This information is sent to the Page Tracker API which
