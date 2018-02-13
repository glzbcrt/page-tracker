# Page Tracker &middot; [![Page Tracker license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/glzbcrt/page-tracker/blob/master/LICENSE) [![Build Status](https://travis-ci.org/glzbcrt/page-tracker.svg?branch=master)](https://travis-ci.org/glzbcrt/page-tracker)

Page Tracker is a sample web application I developed as part of a job interview.
The challenge was to create an application to track the pages where the users have visited and present this information in a feed.

_As a sample application I created both the sample web site and the Page Tracker APIs in the same Java application to simplify the development and tests. In a real application the Page Tracker APIs should be in its own application._
 
You can find a small presentation I created for this development here http://bit.ly/2smAJr6.
 
## Quickstart

You can find an instance of this application running on Heroku at https://glzbcrt-page-tracker.herokuapp.com.
So you do not need to do any install.

Anyway if you want to really install you can download a release from the repository releases page.
Once you have downloaded the JAR file just run it like this:

```
java -jar page-tracker.jar
```

then go to your browser and access **http://localhost:8080/feed** to view pages being hit in real-time.
Open a second tab, access **http://localhost:8080** and navigate the web site. Switch to the feed tab to view the events.

Every page contains a small JavaScript snippet which tracks any hit the page gets.
This information is sent to the Page Tracker API which persists this information and update all Even Feed consumers.

## Stack

The application is a simple Java program using the **Spring Boot** framework. When I build the application a single JAR is created and you can find it in the releases page. The server view engine used is **Thymeleaf**.

I have created a **PageTrackerRepository** interface to store the page hits and contact requests. Later I created an implementation which persists the information in memory.
I am using the dependency injection feature of **Spring** to plug this implementation in the right places.

For the front end I am using **Bootstrap 4** for the UI and **Handlebars.js** to generate the event feed items more easily. 

## JavaScript Snippet

The JavaScript snippet to track web pages can be found at **src/main/resources/static/assets/js/pagetracker.js**.
It's a small JavaScript which uses only native browser resources and do not depend on external libraries. I did it this way to avoid conflicts with existing libraries and also to be as light as possible.

You can view the source code right here:

```javascript
function guid() {
    function _p8(s) {
        var p = (Math.random().toString(16)+"000000000").substr(2,8);
        return s ? "-" + p.substr(0,4) + "-" + p.substr(4,4) : p ;
    }
    return _p8() + _p8(true) + _p8(true) + _p8();
}

var id = localStorage.getItem("pgtid");

if (id == null) {
	id = guid();
	localStorage.setItem("pgtid", id);

	console.log("A pgtid was not found. Created a new one: " + id);
}

xhr = new(this.XMLHttpRequest || ActiveXObject)('MSXML2.XMLHTTP.3.0');
xhr.open('POST', '/pagetracker/hit?userId=' + id + "&url=" + encodeURI(document.location.pathname) + "&timestamp=" + Math.round(+new Date()/1000), true);
xhr.onreadystatechange = function() {};
xhr.send();

console.log("Hit sent to page-tracker.")

```

I am basically generating a random id using a function I found on the Internet and persisting this id in the browser local storage.
This id, the page being rendered and the timestamp are sent to the Page Tracker APIs where they are recorded and published to all consumers of the Event Feed.

## Heroku and Travis CI

You can find an instance of this application running on Heroku at https://glzbcrt-page-tracker.herokuapp.com.

I am building this application using Travis CI. Check the builds history at https://travis-ci.org/glzbcrt/page-tracker.
 
