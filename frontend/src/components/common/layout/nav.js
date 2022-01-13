import React from 'react';
import { Affix, Menu } from 'antd';
import styled from 'styled-components';
import { theme } from '../../../style/theme';
import { Link } from 'react-router-dom';
import { DOCUMENT_URL, GITHUB_URL, SETTING_URL } from '../../../constants/urls';
import {
  FileTextOutlined,
  GithubOutlined,
  SettingOutlined,
} from '@ant-design/icons';
import useDynamicAntdIcon from '../../../hooks/useDynamicAntdIcon';

const Wrapper = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 67px;
  border-right: ${theme.colorLine};
  padding: 30px 0px;
  background-color: ${theme.colorNav};
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

function Nav({ menuList, location }) {
  const getMenu = (menuList) => {
    return menuList.map((menu) => {
      return (
        <Menu.Item key={menu.url} icon={useDynamicAntdIcon(menu.icon)}>
          <Link to={menu.url} />
        </Menu.Item>
      );
    });
  };

  return (
    <>
      <Affix offsetTop={0}>
        <Wrapper>
          <TopMenu>
            {/* 상단 메뉴 */}
            <MenuAntd
              mode="inline"
              selectedKeys={location.pathname}
              defaultSelectedKeys={location.pathname}
            >
              {menuList.length !== 0 && getMenu(menuList)}
            </MenuAntd>
          </TopMenu>

          {/* 하단 메뉴*/}
          <BottomMenu>
            <MenuAntd
              mode="inline"
              selectedKeys={location.pathname}
              defaultSelectedKeys={location.pathname}
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
                icon={
                  <GithubOutlined style={{ fontSize: theme.fontSizeIcon }} />
                }
              >
                <Link to={{ pathname: GITHUB_URL }} target="_blank" />
              </Menu.Item>
            </MenuAntd>
          </BottomMenu>
        </Wrapper>
      </Affix>
    </>
  );
}

export default Nav;
