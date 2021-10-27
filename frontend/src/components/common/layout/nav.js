import React from 'react';
import { Affix, Menu } from 'antd';
import {
  CommentOutlined,
  FileTextOutlined,
  FundOutlined,
  GithubOutlined,
  HomeOutlined,
  SettingOutlined,
} from '@ant-design/icons';
import styled from 'styled-components';
import { theme } from '../../../style/theme';
import { Link } from 'react-router-dom';
import {
  DOCUMENT_URL,
  FEED_URL,
  GITHUB_URL,
  MAIN_URL,
  PLANT_MANAGEMENT_URL,
  SETTING_URL,
} from '../../../constants/urls';

const Wrapper = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 67px;
  border-right: ${theme.colorLine};
  padding: 30px 0px;
`;
const TopMenu = styled.div``;

const BottomMenu = styled.div``;

const MenuAntd = styled(Menu)`
  background-color: ${theme.colorNav};
  .ant-menu-item:hover,
  .ant-menu-submenu:hover,
  .ant-menu-item-active,
  .ant-menu-submenu-active,
  .ant-menu-item-open,
  .ant-menu-submenu-open,
  .ant-menu-item-selected,
  .ant-menu-submenu-selected {
    background-color: ${theme.colorNav} !important;
  }
  .ant-menu-item::after {
    border-right: 0px;
  }
`;

function Nav() {
  return (
    <Affix offsetTop={0}>
      <Wrapper>
        <TopMenu>
          {/* 상단 메뉴 */}
          <MenuAntd
            mode="inline"
            selectedKeys={window.location.pathname}
            defaultSelectedKeys={window.location.pathname}
          >
            <Menu.Item
              key={MAIN_URL}
              icon={<HomeOutlined style={{ fontSize: theme.fontSizeIcon }} />}
            >
              <Link to={MAIN_URL} />
            </Menu.Item>
            <Menu.Item
              key={PLANT_MANAGEMENT_URL}
              icon={<FundOutlined style={{ fontSize: theme.fontSizeIcon }} />}
            >
              <Link to={PLANT_MANAGEMENT_URL} />
            </Menu.Item>
            <Menu.Item
              key={FEED_URL}
              icon={
                <CommentOutlined style={{ fontSize: theme.fontSizeIcon }} />
              }
            >
              <Link to={FEED_URL} />
            </Menu.Item>
          </MenuAntd>
        </TopMenu>

        {/* 하단 메뉴*/}
        <BottomMenu>
          <MenuAntd
            mode="inline"
            selectedKeys={window.location.pathname}
            defaultSelectedKeys={window.location.pathname}
          >
            <Menu.Item
              key={SETTING_URL}
              icon={
                <SettingOutlined style={{ fontSize: theme.fontSizeIcon }} />
              }
            >
              <Link to={SETTING_URL} />
            </Menu.Item>
            <Menu.Item
              key={DOCUMENT_URL}
              icon={
                <FileTextOutlined style={{ fontSize: theme.fontSizeIcon }} />
              }
            >
              <Link to={DOCUMENT_URL} />
            </Menu.Item>
            <Menu.Item
              key={GITHUB_URL}
              icon={<GithubOutlined style={{ fontSize: theme.fontSizeIcon }} />}
            >
              <Link to={{ pathname: GITHUB_URL }} target="_blank" />
            </Menu.Item>
          </MenuAntd>
        </BottomMenu>
      </Wrapper>
    </Affix>
  );
}

export default Nav;
