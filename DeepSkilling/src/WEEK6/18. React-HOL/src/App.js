import './App.css';
import { CohortsData} from './components/Cohort'
import CohortDetails from './components/CohortDetails'; 

function App() {
 
  return (
  <div>
    <h1>Cohorts Details</h1>
    {CohortsData.map(cohort => <CohortDetails key={cohort.cohortCode} cohort={cohort}/>)}
  </div>
  );
}

export default App;
