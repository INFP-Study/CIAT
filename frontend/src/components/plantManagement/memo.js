import React from 'react';
import styled from 'styled-components';
import { Card } from 'antd';

const CardAntd = styled(Card)`
  height: 47%;
  width: 40vh;
  .ant-card-head {
    min-height: 30px;
  }
  .ant-card-body {
    padding: 10px;
    height: 17vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .ant-card-head-title {
    padding: 3px 0;
  }
  .ant-card-head-wrapper {
    height: 100%;
  }
`;

const Content = styled.textarea`
  width: 100%;
  height: 100%;
  background-color: transparent;
  border: none;
  resize: none;

  &:focus {
    outline: none;
  }
`;

const Memo = () => {
  return (
    <CardAntd
      className={'memo'}
      hoverable
      title={'메모'}
      style={{ background: '#fffce6', height: '47%' }}
    >
      <Content
        placeholder={'메모를 이용하여 나만의 식물 정보를 기록해보세요.'}
      />
    </CardAntd>
  );
};

export default Memo;
