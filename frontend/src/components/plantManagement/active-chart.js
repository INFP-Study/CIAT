import React from 'react';
import { Card } from 'antd';
import { Pie } from '@ant-design/charts';
import styled from 'styled-components';

const AntdCard = styled(Card)`
  width: 100%; 
  height: 100%;
  .ant-card-body {
    height: 80%;
  }
`;

const Circle = styled.div`
  width: 1px;
  height: 1px;
  border: 6px solid rgb(163, 151, 198);
  border-radius: 50%;
  margin: auto;
`;

const StateList = styled.ul`
  margin-top: 10px;
  list-style: none;
  display: flex;
  justify-content: space-around;
  padding: 0;
  li:nth-child(1) {
    div {
      border: 6px solid #96A8CB;
    }
  }
  li:nth-child(2) {
    div {
      border: 6px solid #7EA592;
    }
  }
  li:nth-child(3) {
    div {
      border: 6px solid #AD9CBB;
    }
  }
  li:nth-child(4) {
    div {
      border: 6px solid #DA9393;
    }
  }
`;

const StateText = styled.p`
  margin-top: 5px;
`;

const ActiveChart = () => {
  const data = [
    {
      type: '좋음',
      value: 27,
    },
    {
      type: '보통',
      value: 25,
    },
    {
      type: '나쁨',
      value: 18,
    },
    {
      type: '위험',
      value: 15,
    },
  ];
  const config = {
    height: 220,
    appendPadding: 10,
    data,
    angleField: 'value',
    colorField: 'type',
    color: ['#96A8CB', '#7EA592', '#AD9CBB', '#DA9393'],
    radius: 1,
    innerRadius: 0.6,
    legend: false,
    label: {
      type: 'inner',
      offset: '-50%',
      content: '',
      style: {
        textAlign: 'center',
        fontSize: 14,
      },
    },
    interactions: [
      {
        type: 'element-selected',
      },
      {
        type: 'element-active',
      },
    ],
    state: {
      active: {
        animate: { duration: 100, easing: 'easeLinear' },
        style: {
          lineWidth: 2,
          stroke: '',
        },
      },
    },
    statistic: {
      title: false,
      content: {
        style: {
          whiteSpace: 'pre-wrap',
          overflow: 'hidden',
          textOverflow: 'ellipsis',
        },
        content: '',
      },
    },
  };
  return (
    <div style={{ height: '100%' }}>
      <AntdCard hoverable title={'최근 3개월 식물상태'}>
        <Pie {...config} />
        <StateList>
          <li><Circle /><StateText>좋음</StateText></li>
          <li><Circle /><StateText>보통</StateText></li>
          <li><Circle /><StateText>나쁨</StateText></li>
          <li><Circle /><StateText>위험</StateText></li>
        </StateList>
      </AntdCard>
    </div>
  );
};

export default ActiveChart;