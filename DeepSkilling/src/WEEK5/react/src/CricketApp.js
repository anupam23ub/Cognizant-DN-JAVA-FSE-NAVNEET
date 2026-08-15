import React from 'react';

const players = [
  { name: "Jack", score: 50 }, { name: "Michael", score: 70 }, { name: "John", score: 40 }, { name: "Ann", score: 61 }, { name: "Elisabeth", score: 61 }, { name: "Sachin", score: 95 },
  { name: "Dhoni", score: 100 }, { name: "Virat", score: 84 }, { name: "Jadeja", score: 64 }, { name: "Raina", score: 75 }, { name: "Rohit", score: 80 }
];
const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

const OddPlayers = ([first, , third, , fifth]) => <div><li> First : {first} </li><li> Third : {third} </li><li> Fifth : {fifth}</li></div>;
const EvenPlayers = ([, second, , fourth, , sixth]) => <div><li> Second : {second} </li><li> Fourth : {fourth} </li><li> Sixth : {sixth}</li></div>;

export default function CricketApp() {
  const flag = true; 
  const players70 = [];
  if (flag) {
    return (
      <div>
        <h1> List of Players</h1>
        {players.map((item, index) => <div key={index}><li>Mr. {item.name} <span>{item.score}</span></li></div>)}
        <hr />
        <h1> List of Players having Scores Less than 70 </h1>
        {players.map((item) => { if (item.score <= 70) { players70.push(item); } return null; })}
        {players70.map((item, index) => <div key={index}><li>Mr. {item.name} <span>{item.score}</span></li></div>)}
      </div>
    );
  } else {
    return (
      <div>
        <h1> Odd Players </h1>{OddPlayers(IndianTeam)}<hr />
        <h1> Even Players</h1>{EvenPlayers(IndianTeam)}<hr />
        <h1> List of Indian Players Merged:</h1>{IndianPlayers.map((p, i) => <li key={i}>Mr. {p}</li>)}
      </div>
    );
  }
}