
console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Community Portal Loaded Successfully");
});

const eventName = "Music Festival";
const eventDate = "2026-07-15";

let availableSeats = 50;

console.log(
    `Event: ${eventName}, Date: ${eventDate}, Seats: ${availableSeats}`
);

let events = [
    {
        name: "Music Festival",
        category: "Music",
        seats: 50,
        upcoming: true
    },
    {
        name: "Tech Workshop",
        category: "Technology",
        seats: 20,
        upcoming: true
    },
    {
        name: "Food Carnival",
        category: "Food",
        seats: 0,
        upcoming: false
    }
];

events.forEach(event => {

    if (event.upcoming && event.seats > 0) {

        console.log(
            `${event.name} is available`
        );

    } else {

        console.log(
            `${event.name} is hidden`
        );
    }
});

function safeRegistration(event) {

    try {

        if (event.seats <= 0) {

            throw new Error(
                "No seats available"
            );
        }

        event.seats--;

        console.log(
            "Registration Successful"
        );

    } catch (error) {

        console.error(
            error.message
        );
    }
}

function addEvent(event) {

    events.push(event);
}

function registerUser(eventName) {

    const event =
        events.find(
            e => e.name === eventName
        );

    if (event) {

        safeRegistration(event);

        alert(
            `Successfully registered for ${eventName}`
        );

        renderEvents();
    }
}

function filterEventsByCategory(
    category,
    callback
) {

    const filtered =
        events.filter(
            event =>
                event.category === category
        );

    callback(filtered);
}

function createRegistrationTracker() {

    let count = 0;

    return function () {

        count++;

        return count;
    };
}

const musicTracker =
    createRegistrationTracker();

function Event(
    name,
    category,
    seats
) {

    this.name = name;

    this.category = category;

    this.seats = seats;
}

Event.prototype.checkAvailability =
    function () {

        return this.seats > 0;
    };

const sampleEvent =
    new Event(
        "Community Seminar",
        "Education",
        30
    );

console.log(
    Object.entries(sampleEvent)
);

events.push({
    name: "Dance Show",
    category: "Music",
    seats: 40,
    upcoming: true
});

const musicEvents =
    events.filter(
        event =>
            event.category === "Music"
    );

console.log(musicEvents);

const displayCards =
    events.map(
        event =>
            `Workshop on ${event.name}`
    );

console.log(displayCards);

function renderEvents() {

    const container =
        document.querySelector(
            "#eventContainer"
        );

    if (!container) return;

    container.innerHTML = "";

    events
        .filter(
            event =>
                event.upcoming &&
                event.seats > 0
        )
        .forEach(event => {

            const card =
                document.createElement("div");

            card.className =
                "eventCard";

            card.innerHTML = `
                <h3>${event.name}</h3>
                <p>${event.category}</p>
                <button onclick="registerUser('${event.name}')">
                    Register
                </button>
            `;

            container.appendChild(card);
        });
}

window.addEventListener(
    "load",
    renderEvents
);


function showConfirmation() {

    document.getElementById(
        "formOutput"
    ).value =
        "Registration Submitted Successfully";
}

function showFee() {

    const eventType =
        document.getElementById(
            "eventType"
        ).value;

    let fee = 0;

    if (eventType === "Music") {

        fee = 200;
    }

    if (eventType === "Technology") {

        fee = 500;
    }

    if (eventType === "Sports") {

        fee = 300;
    }

    document.getElementById(
        "eventFee"
    ).innerText =
        `Fee: ₹${fee}`;
}

function countCharacters() {

    const messageText =
        document.getElementById(
            "message"
        );

    const feedbackText =
        document.getElementById(
            "feedbackText"
        );

    let count = 0;

    if (messageText) {

        count = messageText.value.length;
    }

    if (
        feedbackText &&
        document.activeElement === feedbackText
    ) {

        count = feedbackText.value.length;
    }

    const counter =
        document.getElementById(
            "charCount"
        );

    if (counter) {

        counter.innerText = count;
    }
}

function submitFeedback() {

    const feedback =
        document.getElementById(
            "feedbackText"
        ).value;

    if (feedback.trim() === "") {

        alert(
            "Please enter feedback."
        );

        return;
    }

    document.getElementById(
        "feedbackMessage"
    ).innerText =
        "Feedback submitted successfully.";

    console.log(
        "Feedback Submitted:",
        feedback
    );

    document.getElementById(
        "feedbackText"
    ).value = "";
}

function validatePhone() {

    const phone =
        document.getElementById(
            "phone"
        ).value;

    const regex =
        /^[0-9]{10}$/;

    if (
        phone !== "" &&
        !regex.test(phone)
    ) {

        alert(
            "Enter valid 10-digit phone number"
        );
    }
}

function enlargeImage(image) {

    image.style.width = "350px";

    image.style.height = "250px";
}


function fetchEventsPromise() {

    fetch(
        "https://jsonplaceholder.typicode.com/posts"
    )
        .then(response =>
            response.json()
        )
        .then(data =>
            console.log(
                "Promise Data",
                data.slice(0, 5)
            )
        )
        .catch(error =>
            console.error(error)
        );
}

async function fetchEventsAsync() {

    try {

        console.log(
            "Loading..."
        );

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

        const data =
            await response.json();

        console.log(
            "Async Data",
            data.slice(0, 5)
        );

    } catch (error) {

        console.error(error);
    }
}


function greetUser(
    name = "Guest"
) {

    console.log(
        `Welcome ${name}`
    );
}

const {
    name: firstEventName,
    category: firstCategory
} = events[0];

console.log(
    firstEventName,
    firstCategory
);

const clonedEvents =
    [...events];


const registrationForm =
    document.getElementById(
        "registrationForm"
    );

if (registrationForm) {

    registrationForm.addEventListener(
        "submit",
        async function (event) {

            event.preventDefault();

            console.log(
                "Form Submission Started"
            );

            const form =
                event.target;

            const name =
                form.elements["name"].value;

            const email =
                form.elements["email"].value;

            const selectedEvent =
                document.getElementById(
                    "eventType"
                ).value;

            if (
                name === "" ||
                email === ""
            ) {

                alert(
                    "Fill all required fields"
                );

                return;
            }

            await submitRegistration({
                name,
                email,
                selectedEvent
            });
        }
    );
}


async function submitRegistration(
    userData
) {

    try {

        await new Promise(
            resolve =>
                setTimeout(
                    resolve,
                    2000
                )
        );

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts",
                {
                    method: "POST",
                    headers: {
                        "Content-Type":
                            "application/json"
                    },
                    body: JSON.stringify(
                        userData
                    )
                }
            );

        if (response.ok) {

            alert(
                "Registration Successful"
            );

        } else {

            alert(
                "Registration Failed"
            );
        }

    } catch (error) {

        console.error(error);

        alert(
            "Server Error"
        );
    }
}


function videoReady() {

    document.getElementById(
        "videoStatus"
    ).innerText =
        "Video ready to play";
}


function savePreference() {

    const eventType =
        document.getElementById(
            "eventType"
        ).value;

    localStorage.setItem(
        "preferredEvent",
        eventType
    );

    sessionStorage.setItem(
        "sessionEvent",
        eventType
    );
}

window.addEventListener(
    "load",
    () => {

        const saved =
            localStorage.getItem(
                "preferredEvent"
            );

        if (saved) {

            document.getElementById(
                "eventType"
            ).value = saved;

            showFee();
        }
    }
);

function clearPreferences() {

    localStorage.clear();

    sessionStorage.clear();

    alert(
        "Preferences Cleared"
    );
}


function findLocation() {

    if (
        !navigator.geolocation
    ) {

        alert(
            "Geolocation not supported"
        );

        return;
    }

    navigator.geolocation.getCurrentPosition(

        position => {

            document.getElementById(
                "coordinates"
            ).innerText =
                `Latitude: ${position.coords.latitude}
Longitude: ${position.coords.longitude}`;
        },

        error => {

            document.getElementById(
                "coordinates"
            ).innerText =
                error.message;
        },

        {
            enableHighAccuracy: true,
            timeout: 10000,
            maximumAge: 0
        }
    );
}


window.onbeforeunload =
    function () {

        return (
            "Form data may be lost."
        );
    };


$(document).ready(function () {

    $("#registerBtn").click(
        function () {

            $(".eventCard").fadeIn();
        }
    );

    $(".eventCard").dblclick(
        function () {

            $(this).fadeOut();
        }
    );
});

console.log(
    "Debugging Enabled"
);

fetchEventsPromise();

fetchEventsAsync();