import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { Button, Card, Input, Space } from 'antd';
import { MinusOutlined, PlusOutlined } from '@ant-design/icons';
import { getDecrement, getIncrement } from '../../store/counter';
import { TITLE } from '../../constants';

const TitleTest = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: green;
`;

function Home() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  return (
    <div>
      <TitleTest>{TITLE}</TitleTest>
      <Space align="center">
        <Card title="Count Saga Test" style={{ width: 300 }}>
          <Space size="middle">
            <Button
              type="primary"
              danger
              onClick={() => dispatch({ type: getDecrement.type })}
            >
              <MinusOutlined />
            </Button>
            <Input value={count} />
            <Button
              type="primary"
              onClick={() => dispatch({ type: getIncrement.type })}
            >
              <PlusOutlined />
            </Button>
          </Space>
        </Card>
      </Space>
    </div>
  );
}

export default Home;
