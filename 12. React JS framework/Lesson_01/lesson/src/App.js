import logo from './logo.svg';
import './App.css';

function App(props) {
  const userName = 'Helga'
  return (
    <div className="App">
      
        <h1>Hello, {userName}!</h1>
        <Heading />
        

My First React App
<h3>Hello, {props.name}</h3>
    </div>
  );
}

function Heading() {
  return (
    <h2>Новый текст внутри заголовка</h2>
  )
}

export default App;
