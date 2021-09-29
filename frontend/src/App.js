import React from 'react';
import { Button, Checkbox, version, DatePicker } from 'antd';
import 'antd/dist/antd.less';
import './App.css';

function App() {
  function onChange(e) {
    console.log(`checked = ${e.target.checked}`);
  }

  function onChange2(date, dateString) {
    console.log(date, dateString);
  }

  return (
    <div>
      <h2>Welcome to React App</h2>
      <h3>Date : {new Date().toDateString()}</h3>
      <h1>antd version: {version}</h1>
      <Checkbox onChange={onChange}>Checkbox</Checkbox>
      <Button onClick={(e) => console.log(e)}>클릭</Button>
      <DatePicker onChange={onChange2} />
      <Button type="primary" style={{ marginLeft: 8 }}>
        Primary Button
      </Button>
    </div>
  );
}

export default App;
