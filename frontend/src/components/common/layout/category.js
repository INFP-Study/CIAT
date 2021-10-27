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

function Category() {
  const [collapsed, setCollapsed] = useState(false);

  const toggle = () => {
    setCollapsed(!collapsed);
  };

  return (
    <Affix offsetTop={0}>
      <SiderAntd trigger={null} collapsible collapsed={collapsed}>
        <CategoryTitle>{FEED}</CategoryTitle>
        <MenuAntd mode="inline" defaultSelectedKeys={['0']}>
          <Menu.Item
            key="0"
            icon={<MdAccountCircle style={{ fontSize: theme.fontSizeIcon }} />}
          >
            {/* <Link to={FEED_DAILY_URL}> 일상</Link> */}
            일상
          </Menu.Item>
          <Menu.Item
            key="1"
            icon={<UserOutlined style={{ fontSize: theme.fontSizeIcon }} />}
          >
            맛집
          </Menu.Item>
          <Menu.Item
            key="2"
            icon={
              <VideoCameraOutlined style={{ fontSize: theme.fontSizeIcon }} />
            }
          >
            취미생활
          </Menu.Item>
          <Menu.Item
            key="3"
            icon={<UploadOutlined style={{ fontSize: theme.fontSizeIcon }} />}
          >
            건강
          </Menu.Item>
          <Menu.Item
            key="4"
            icon={<UploadOutlined style={{ fontSize: theme.fontSizeIcon }} />}
          >
            인테리어
          </Menu.Item>
        </MenuAntd>
      </SiderAntd>
    </Affix>
  );
}

export default Category;
