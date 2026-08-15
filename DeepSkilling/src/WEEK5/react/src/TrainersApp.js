import React from 'react';
import { Routes, Route, Link, useParams } from 'react-router-dom';

class Trainer {
  constructor(trainerId, name, email, phone, technology, skills) {
    this.trainerId = trainerId; this.name = name; this.email = email; this.phone = phone; this.technology = technology; this.skills = skills;
  }
}
const trainersMock = [
  new Trainer('t-syed8', 'Syed Khaleelullah', 'khaleelullah@cognizant.com', '97676516962', '.NET', ['C#', 'SQL Server', 'React', '.NET Core']),
  new Trainer('t-jojo', 'Jojo Jose', 'jojo@cognizant.com', '9897199231', 'Java', ['Java', 'JSP', 'Angular', 'Spring']),
  new Trainer('t-elisa', 'Elisa Jones', 'elisa@cognizant.com', '9871212235', 'Python', ['Python', 'Django', 'Angular'])
];

const TrainersList = () => (
  <div><h2>Trainers List</h2><ul>{trainersMock.map(t => <li key={t.trainerId}><Link to={`/lab6/trainers/${t.trainerId}`}>{t.name}</Link></li>)}</ul></div>
);
const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.trainerId === id);
  if (!trainer) return <div>Trainer not found</div>;
  return <div><h2>Trainers Details</h2><h3>{trainer.name} ({trainer.technology})</h3><p>{trainer.email}</p><p>{trainer.phone}</p><ul>{trainer.skills.map((skill, index) => <li key={index}>{skill}</li>)}</ul></div>;
};
const Home = () => <h2>Welcome to My Academy trainers page</h2>;

export default function TrainersApp() {
  return (
    <div>
      <h1>My Academy Trainers App</h1>
      <Link to="/lab6">Home</Link> | <Link to="/lab6/trainers">Show Trainers</Link>
      <hr />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList />} />
        <Route path="/trainers/:id" element={<TrainerDetail />} />
      </Routes>
    </div>
  );
}