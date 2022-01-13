import React from 'react';
import { Space } from 'antd';
import Image from '../components/plant-management/image';
import Activity from '../components/plant-management/activity';
import Chart from '../components/plant-management/chart';
import Stats from '../components/plant-management/stat';
import Info from '../components/plant-management/info';
import Memo from '../components/plant-management/memo';
import Log from '../components/plant-management/log';

const activities = [
  {
    type: '물주기',
    value: 1,
  },
  {
    type: '햇빛',
    value: 3,
  },
  {
    type: '통풍',
    value: 2,
  },
  {
    type: '분갈이',
    value: 3,
  },
  {
    type: '영양',
    value: 4,
  },
  {
    type: '가지',
    value: 2,
  },
  {
    type: '분무',
    value: 1,
  },
];

const status = [
  {
    type: '좋음',
    value: 1,
  },
  {
    type: '보통',
    value: 3,
  },
  {
    type: '나쁨',
    value: 2,
  },
  {
    type: '위험',
    value: 3,
  },
];

const tempData = {
  activityData: [
    {
      id: 0,
      name: '물주기',
      icon: 'IoColorFillOutline',
    },
    {
      id: 1,
      name: '햇빛',
      icon: 'IoSunnyOutline',
    },
    {
      id: 2,
      name: '통풍',
      icon: 'BiWind',
    },
    {
      id: 3,
      name: '분갈이',
      icon: 'VscArchive',
    },
    {
      id: 4,
      name: '영양',
      icon: 'RiPlantLine',
    },
    {
      id: 5,
      name: '가지',
      icon: 'RiScissors2Fill',
    },
    {
      id: 6,
      name: '분무',
      icon: 'BiSprayCan',
    },
    {
      id: 7,
      name: '관찰',
      icon: 'IoSearchSharp',
    },
  ],

  statData: [
    {
      id: 0,
      name: '좋음',
      icon: 'BsEmojiLaughingFill',
    },
    {
      id: 1,
      name: '보통',
      icon: 'BsEmojiNeutralFill',
    },
    {
      id: 2,
      name: '나쁨',
      icon: 'BsEmojiFrownFill',
    },
    {
      id: 3,
      name: '죽음',
      icon: 'IoColorFillOutline',
    },
    {
      id: 4,
      name: '새싹',
      icon: 'IoLeafSharp',
    },
    {
      id: 5,
      name: '개화',
      icon: 'IoMdFlower',
    },
    {
      id: 6,
      name: '마름',
      icon: 'IoLeafOutline',
    },
    {
      id: 7,
      name: '추움',
      icon: 'BsSnow',
    },
  ],
};
const data = {
  info: {
    title: '토마토',
    content: '가지목 가지과',
    a: '원산지 : 남아메리카, 중앙아메리카',
  },
  management: {
    title: '관리방법',
    content:
      '방울토마토를 비롯해 집에서 채소를 키우려면 상토를 화분에 넣고, 중앙에 2/3나 3/4 정도 너무 깊지 않게 씨앗이나 모종을 심는 것이 중요 더보기...',
  },
};

function PlantManagementContainer() {
  return (
    <Space size={20}>
      <Space direction="vertical" size={20}>
        <Space size={20}>
          <Image />
          <Activity plantName={'토마토'} data={tempData} />
        </Space>
        <Space size={20}>
          <Chart title={'최근 3개월 활동내역'} data={activities} />
          <Chart title={'최근 3개월 식물상태'} data={status} />
          <Space direction="vertical" size={20}>
            <Stats title={'디데이'} />
            <Stats title={'Like'} />
          </Space>
        </Space>
      </Space>
      <Space direction="vertical" size={20}>
        <Info data={data.info} />
        <Info data={data.management} />
        <Log title={'로그'} />
        <Memo title={'메모'} />
      </Space>
    </Space>
  );
}

export default PlantManagementContainer;
