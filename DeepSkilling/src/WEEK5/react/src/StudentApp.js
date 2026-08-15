import React, { Component } from 'react';

class Home extends Component {
  render() { return <div><h3>Welcome to the Home Page of Student Management Portal</h3></div>; }
}
class About extends Component {
  render() { return <div><h3>Welcome to the About Page of Student Management Portal</h3></div>; }
}
class Contact extends Component {
  render() { return <div><h3>Welcome to the Contact Page of Student Management Portal</h3></div>; }
}

export default function StudentApp() {
  return (
    <div className="container" style={{ textAlign: 'center' }}>
      <Home />
      <About />
      <Contact />
    </div>
  );
}