import Sider from 'antd/lib/layout/Sider';
import { Affix, Menu } from 'antd';
import React, { useState } from 'react';
import {
  UploadOutlined,
  UserOutlined,
  VideoCameraOutlined,
} from '@ant-design/icons';
import styled from 'styled-components';
import { theme } from '../../../style/theme';
import { FEED } from '../../../constants';
import { MdAccountCircle } from 'react-icons/md';
import { FEED_DAILY_URL } from '../../../constants/urls';
import { Link } from 'react-router-dom';
import { FcShop, FcAlarmClock, FcCalendar, FcSteam } from 'react-icons/fc';

const SiderAntd = styled(Sider)`
  width: 200px;
  height: 100vh;
  background-color: ${theme.colorCategory};
  padding: 30px 0px;
  border-right: ${theme.borderLine};
  border-left: ${theme.borderLine};
`;

const MenuAntd = styled(Menu)`
  background-color: ${theme.colorCategory};
  .ant-menu-item-selected,
  .ant-menu-item-active,
  .ant-menu-item::after {
    border-right: 0px;
    color: ${theme.colorText};
  }
`;

const CategoryTitle = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightSemiBold};
  padding: 0px 15px;
  height: 40px;
  margin-top: 5.5px;
`;

function Category({ menuList }) {
  const [collapsed, setCollapsed] = useState(false);
  const toggle = () => {
    setCollapsed(!collapsed);
  };

  const getCategoryList = (menuList) => {
    return menuList
      .filter((menu) => menu.url === location.pathname)
      .map((menuItem) => menuItem.categoryList)
      .map((arr) =>
        arr.map((category, i) => {
          return (
            <Menu.Item
              key={category.id}
              icon={<FcShop style={{ fontSize: theme.fontSizeIcon }} />}
            >
              <Link to={category.url}> {category.name}</Link>
            </Menu.Item>
          );
        })
      );
  };

  return (
    <Affix offsetTop={0}>
      <SiderAntd trigger={null} collapsible collapsed={collapsed}>
        <CategoryTitle>
          {menuList.map((menu) => menu.url === location.pathname && menu.name)}
        </CategoryTitle>
        <MenuAntd mode="inline" defaultSelectedKeys={['0']}>
          {getCategoryList(menuList)}
        </MenuAntd>
      </SiderAntd>
    </Affix>
  );
}

export default Category;
