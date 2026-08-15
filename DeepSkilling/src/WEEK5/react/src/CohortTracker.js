import React from 'react';
import styles from './CohortDetails.module.css';

const cohorts = [
  { id: 'INTADMDF10', name: '.NET FSD', start: '22-Feb-2022', status: 'Scheduled', coach: 'Aathma', trainer: 'Jojo Jose' },
  { id: 'ADM21JF014', name: 'Java FSD', start: '10-Sep-2021', status: 'Ongoing', coach: 'Apoorv', trainer: 'Elisa Smith' },
  { id: 'CDBJF21025', name: 'Java FSD', start: '24-Dec-2021', status: 'Ongoing', coach: 'Aathma', trainer: 'John Doe' }
];

export default function CohortTracker() {
  return (
    <div>
      <h2>Cohorts Details</h2>
      {cohorts.map(c => (
        <div key={c.id} className={styles.box}>
          <h3 style={{ color: c.status === 'Ongoing' ? 'green' : 'blue' }}>{c.id} - {c.name}</h3>
          <dl>
            <dt>Started On</dt><dd>{c.start}</dd>
            <dt>Current Status</dt><dd>{c.status}</dd>
            <dt>Coach</dt><dd>{c.coach}</dd>
            <dt>Trainer</dt><dd>{c.trainer}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
}