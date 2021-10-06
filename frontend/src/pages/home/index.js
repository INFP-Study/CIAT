import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { Button, Checkbox, DatePicker, version } from 'antd';
import { getDecrement, getIncrement } from '../../store/counter';
import { getLoginTest } from '../../store/login';

const TitleTest = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: red;
`;

function Home() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  function onChange(e) {
    console.log(`checked = ${e.target.checked}`);
  }

  function onChange2(date, dateString) {
    console.log(date, dateString);
  }

  return (
    <div>
      <TitleTest>test</TitleTest>
      <br />
      home
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
      <div>
        <button
          aria-label="Increment value"
          onClick={() => dispatch({ type: getIncrement.type })}
        >
          Increment
        </button>
        <span>{count}</span>
        <button
          aria-label="Decrement value"
          onClick={() => dispatch({ type: getDecrement.type })}
        >
          Decrement
        </button>
        <Button onClick={() => dispatch({ type: getLoginTest.type })}>
          login
        </Button>
      </div>
    </div>
  );
}

export default Home;
