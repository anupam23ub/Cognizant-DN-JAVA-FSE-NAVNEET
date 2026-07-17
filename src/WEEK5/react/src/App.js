import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import FirstReact from './FirstReact';
import StudentApp from './StudentApp';
import ScoreApp from './ScoreCalculator';
import { Posts } from './BlogApp';
import CohortTracker from './CohortTracker';
import TrainersApp from './TrainersApp';
import { OnlineShopping } from './ShoppingApp';
import { CountPeople } from './CounterApp';
import CricketApp from './CricketApp';
import OfficeSpace from './OfficeSpace';

export default function App() {
  return (
    <BrowserRouter>
      <div style={{ display: 'flex', fontFamily: 'sans-serif' }}>
        <div style={{ width: '250px', padding: '20px', backgroundColor: '#f4f4f4', height: '100vh' }}>
          <h3>React Hands-On Labs</h3>
          <ul style={{ listStyleType: 'none', padding: 0, lineHeight: '2' }}>
            <li><Link to="/lab1">Lab 1: First React</Link></li>
            <li><Link to="/lab2">Lab 2: Student App</Link></li>
            <li><Link to="/lab3">Lab 3: Score Calculator</Link></li>
            <li><Link to="/lab4">Lab 4: Blog App</Link></li>
            <li><Link to="/lab5">Lab 5: Cohort Tracker</Link></li>
            <li><Link to="/lab6">Lab 6: Trainers App</Link></li>
            <li><Link to="/lab7">Lab 7: Shopping App</Link></li>
            <li><Link to="/lab8">Lab 8: Counter App</Link></li>
            <li><Link to="/lab9">Lab 9: Cricket App</Link></li>
            <li><Link to="/lab10">Lab 10: Office Space</Link></li>
          </ul>
        </div>
        
        <div style={{ padding: '20px', flex: 1 }}>
          <Routes>
            <Route path="/" element={<h2>Select a lab from the menu to run it.</h2>} />
            <Route path="/lab1" element={<FirstReact />} />
            <Route path="/lab2" element={<StudentApp />} />
            <Route path="/lab3" element={<ScoreApp />} />
            <Route path="/lab4" element={<Posts />} />
            <Route path="/lab5" element={<CohortTracker />} />
            <Route path="/lab6/*" element={<TrainersApp />} />
            <Route path="/lab7" element={<OnlineShopping />} />
            <Route path="/lab8" element={<CountPeople />} />
            <Route path="/lab9" element={<CricketApp />} />
            <Route path="/lab10" element={<OfficeSpace />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}