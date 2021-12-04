import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Card, Input, Space } from 'antd';
import { MinusOutlined, PlusOutlined } from '@ant-design/icons';
import { getDecrement, getIncrement } from '../store/counter';
import SiteLayout from '../components/common/layout';
/* import { getGoogleLogin } from '../store/auth'; */

function Home() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  return (
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
          {/* <Button
              type="primary"
              onClick={() => dispatch({ type: getGoogleLogin.type })}
            >
              <PlusOutlined />
            </Button> */}
        </Space>
      </Card>
    </Space>
  );
}

export default Home;
